package com.design.machineManagement.service.impl;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Machine;
import com.design.machineManagement.mapper.MachineMapper;
import com.design.machineManagement.pojo.ScheduleClass;
import com.design.machineManagement.service.MachineService;
import com.design.machineManagement.util.PageUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.design.machineManagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * (Machine)表服务实现类
 *
 * @author makejava
 * @since 2022-07-25 09:09:10
 */
@Service("machineService")
public class MachineServiceImpl implements MachineService {
    @Autowired
    private MachineMapper machineMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Machine> queryById(Integer id) {
       Machine machine=this.machineMapper.queryById(id);
         return RestFulBean.succ(machine);
    }

    /**
     * 新增数据
     *
     * @param machine 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Machine machine) {

        //判空
        if(machine.getRoomNo()==null){
            return RestFulBean.error("机房号不能为空");
        }
        if(machine.getNum()==null){
            return RestFulBean.error("人数不能为空");
        }
        //根据机房号查找数据
        Machine mac =machineMapper.getByRoomNo(machine.getRoomNo());
        if(mac!=null) //机房号不能重录入
        {
            return RestFulBean.error(machine.getRoomNo()+"机房号不能重复录入");
        }
        this.machineMapper.insert(machine);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param machine 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Machine machine) {
        //判空
        if(machine.getRoomNo()==null){
            return RestFulBean.error("机房号不能为空");
        }
        if(machine.getNum()==null){
            return RestFulBean.error("人数不能为空");
        }
        this.machineMapper.update(machine);
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
        this.machineMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<Map> getList(Page<Machine> page) throws Exception {
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Machine> list= machineMapper.getPageListByCondition(page);
        if(list.size()>0){  //数据大于0 才进去
             for(Machine machine: list){
                 //本地的图片路劲
                machine.setImageUrl("http://localhost:8087/file/"+ machine.getImage());
             }
        }
        //根据条件查询数据的条数
        Integer count = machineMapper.getPageListCount(page);
        //拿到总条数跟总页数 在前端渲染
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //讲查询的数据用map对象返回
        map.put("list",list);
        return RestFulBean.succ(map);
    }

    @Override
    public RestFulBean<List<Machine>> getAllList() {
        //要查很多数据 所有用集合list接数据库数据
        List<Machine> list =machineMapper.getAllList();
        return RestFulBean.succ(list);
    }
}
