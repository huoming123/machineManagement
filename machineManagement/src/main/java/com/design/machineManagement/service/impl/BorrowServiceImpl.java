package com.design.machineManagement.service.impl;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Borrow;
import com.design.machineManagement.mapper.BorrowMapper;
import com.design.machineManagement.pojo.Machine;
import com.design.machineManagement.service.BorrowService;
import com.design.machineManagement.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.design.machineManagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (Borrow)表服务实现类
 *
 * @author makejava
 * @since 2022-07-25 16:13:04
 */
@Service("borrowService")
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowMapper borrowMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Borrow> queryById(Integer id) {
        Borrow borrow = this.borrowMapper.queryById(id);
        return RestFulBean.succ(borrow);
    }

    /**
     * 新增数据
     *
     * @param borrow 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Borrow borrow) {
        if (borrow.getStartTime().equals(borrow.getEndTime())) {
            return RestFulBean.error("时间段不能相等");
        }
        Integer aa = null;
        //时间段根据：去切割数据 比如 08:00 切成 08 00
        String first = borrow.getStartTime().split(":")[0]; //取第一个 比如 08
        if ("12".equals(first)) {  //判断开始时间段是否等于12
            return RestFulBean.error("时间段包含午休时间,请重新选择");
        }
        if (first.startsWith("0")) { //再判断切出来的第一个first 是否是0开头的 比如 08
            String result = first.split("0")[1]; //如果是 则根据0再切割 然后取第二个 则 取 8
            aa = Integer.parseInt(String.valueOf(result)); //把字符串转为整形
        } else {//如果不是0开头的 则 直接把它转为整形 比如 10
            aa = Integer.parseInt(String.valueOf(first));
        }
        //第二个时间的同理可得
        Integer bb = null;
        String second = borrow.getEndTime().split(":")[0];
        if (second.startsWith("0")) {
            String result1 = second.split("0")[1];
            bb = Integer.parseInt(String.valueOf(result1));
        } else {
            bb = Integer.parseInt(String.valueOf(second));
        }
        //第二个时间段减去第一个时间
        if (bb - aa < 0) {
            return RestFulBean.error("开始时间段不能大于结束时间段");
        }
        if (bb - aa > 2) {
            return RestFulBean.error("机房课程只能选两节课");
        }
        //获取系统当前时间
        Date date = new Date();
        //将当前日期时间转为毫秒值
        long t1 = date.getTime();
        //前端传来的上课时间
        long t2 = borrow.getClassTime().getTime();
        if(t2-t1<0){
            return RestFulBean.error("上课时间不能小于当前系统时间");
        }
        //不让用户重复提交同个时间段同个机房的申请
        List<Borrow> list1 = borrowMapper.getByUserId(borrow);
        if(list1.size()>0){
            return RestFulBean.error("你已提交该申请,请不要重复申请");
        }
        //根据申请日期 和 开始时间 结束时间 查询数据 跟机房号
        List<Borrow> list = borrowMapper.getByTime(borrow);
        if(list.size()>0){
            return RestFulBean.error("该时间段该机房已经有人申请成功了,请改时间段或者换机房");
        }
        this.borrowMapper.insert(borrow);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param borrow 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> update(Borrow borrow) {
        //根据申请日期 和 开始时间 结束时间 查询数据 跟机房号
        if(borrow.getChecked()==1){ //审核同意的才进去 做个判断 避免同个机房同个时间段多条数据
            List<Borrow> list = borrowMapper.getByTime(borrow);
            if(list.size()>0){
                return RestFulBean.error("该时间段该机房已经有人申请成功了");
            }
        }
        this.borrowMapper.update(borrow);
        return RestFulBean.succ("修改成功");
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public RestFulBean<String> deleteById(Integer id) {
        this.borrowMapper.deleteById(id);
        return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<Map> getList(Page<Borrow> page) throws Exception {
        //前端传来的参数 第几页
        Integer pageNum = page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum = (pageNum - 1) * page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Borrow> list = borrowMapper.getPageListByCondition(page);
        if (list.size() > 0) {  //数据大于0 才进去
            for (Borrow borrow : list) {
                if (borrow.getChecked() == null)  //如果这个字段为空 则表示还没有审核  可以编辑
                {
                    borrow.setDisabled(false);
                } else {//如果这个字段不为空 则表示已经审核  不可以编辑
                    borrow.setDisabled(true);
                }
            }
        }
        //根据条件查询数据的条数
        Integer count = borrowMapper.getPageListCount(page);
        //拿到总条数跟总页数 在前端渲染
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //讲查询的数据用map对象返回
        map.put("list", list);
        return RestFulBean.succ(map);
    }


}
