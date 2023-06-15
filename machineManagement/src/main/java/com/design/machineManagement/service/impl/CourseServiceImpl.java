package com.design.machineManagement.service.impl;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Course;
import com.design.machineManagement.mapper.CourseMapper;
import com.design.machineManagement.pojo.res.RestFulBean;
import com.design.machineManagement.service.CourseService;
import com.design.machineManagement.util.PageUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * (Course)表服务实现类
 *
 * @author makejava
 * @since 2022-07-21 17:21:20
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

  //分页查询
    @Override
    public RestFulBean<Map> getList(Page<Course> page)  throws Exception{
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Course> list= courseMapper.getPageListByCondition(page);
        //根据条件查询数据的条数
        Integer count = courseMapper.getPageListCount(page);
        //拿到总条数跟总页数 在前端渲染
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //讲查询的数据用map对象返回
        map.put("list",list);
        return RestFulBean.succ(map);
    }

    @Override
    public RestFulBean<String> add(Course course) {
        if(course.getCourseName()==null){
            return RestFulBean.error("课程名称不能为空");
        }
        if(course.getHours()==null){
            return RestFulBean.error("课时不能为空");
        }
        courseMapper.add(course);
        return RestFulBean.succ("添加成功");
    }

    @Override
    public RestFulBean<String> update(Course course) {
        if(course.getCourseName()==null){
            return RestFulBean.error("课程名称不能为空");
        }
        if(course.getHours()==null){
            return RestFulBean.error("课时不能为空");
        }
        courseMapper.update(course);
        return RestFulBean.succ("修改成功");
    }

    @Override
    public RestFulBean<String> delete(Course course) {
        courseMapper.delete(course.getId());//根据id去删除
        return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<List<Course>> getAllList() {
        List<Course> list =courseMapper.getAllList();
        return RestFulBean.succ(list);
    }


}
