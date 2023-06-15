package com.design.machineManagement.service.impl;
import com.design.machineManagement.dto.Page;
import com.design.machineManagement.mapper.UsersMapper;
import com.design.machineManagement.pojo.Course;
import com.design.machineManagement.pojo.Machine;
import com.design.machineManagement.pojo.Users;
import com.design.machineManagement.pojo.res.RestFulBean;
import com.design.machineManagement.service.UsersService;
import com.design.machineManagement.util.FileUtil;
import com.design.machineManagement.util.JwtUtils;
import com.design.machineManagement.util.PageUtil;
import com.design.machineManagement.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Users)表服务实现类
 *
 * @author makejava
 * @since 2022-07-07 09:12:43
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private RedisUtil redisUtil;
    @Override
    public RestFulBean<Map<String, Object>> login(Users users) {//RestFulBean<Map<String, Object>> 这样写就是返回map的对象给前端
        if(users.getTeachNo()==null)
        {
            return RestFulBean.error("教师编号不能为空");
        }
        if(users.getPassword()==null)
        {
            return RestFulBean.error("密码不能为空");
        }
        if(users.getRole()==null)
        {
            return RestFulBean.error("角色不能为空");
        }
         String role =users.getRole();//获取角色
         Integer teachNo=users.getTeachNo();//获取教师编号
        //new 一个map对象 用于返回数据给前端
        Map<String,Object> result =new HashMap<>();
        Users user =usersMapper.getByTeachNoAndRole(teachNo,role);//根据教师编号跟角色获取用户数据
        //用户不为空
        if (user!=null){
            //密码跟数据库一样
          if(users.getPassword().equals(user.getPassword()))
         {
             //用jwt生成token
             String token = JwtUtils.getToken(user); //用一个String类型接收token 传一个用户的参数user
             //返回一个map对象
             //将token在前端存起来
             result.put("token",token);
             //返回userName 把这个值在前端存起来
             result.put("userName",user.getUserName());
             //返回userId 在前端存起来 获取菜单的接口需要传用户id
             result.put("userId",user.getId());
             result.put("role",role);
             return RestFulBean.succ(result);
          }
          else{
              return RestFulBean.error("密码错误");
          }

        }
        return RestFulBean.error("用户不存在");
    }

    @Override
    public RestFulBean<Map> getList(Page<Users> page) throws Exception {
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Users> list= usersMapper.getPageListByCondition(page);
        if(list.size()>0){  //数据大于0 才进去
            for(Users users: list){
               users.setImageUrl("http://localhost:8087/file/"+ users.getImage());
            }
        }
        //根据条件查询数据的条数
        Integer count = usersMapper.getPageListCount(page);
        //拿到总条数跟总页数 在前端渲染
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //讲查询的数据用map对象返回
        map.put("list",list);
        return RestFulBean.succ(map);
    }

    @Override
    public RestFulBean<String> insert(Users users) {
        if(users.getTeachNo()==null){
            return RestFulBean.error("教师编号不能为空");
        }
        if(users.getUserName()==null){
            return RestFulBean.error("姓名不能为空");
        }
        if(users.getSex()==null){
            return RestFulBean.error("性别不能为空");
        }
        Users usered =usersMapper.getByTeachNo(users.getTeachNo());
        if (usered!=null){
            return RestFulBean.error("该教师编号已有");
        }

        //新增时密码默认为学号 可以去个人中心修改密码
        users.setPassword(users.getTeachNo().toString());
        usersMapper.insert(users);
        return RestFulBean.succ("新增成功");
    }

    @Override
    public RestFulBean<String> update(Users users) {
        usersMapper.update(users);
        if(users.getUserName()==null){
            return RestFulBean.error("姓名不能为空");
        }
        if(users.getSex()==null){
            return RestFulBean.error("性别不能为空");
        }
        return RestFulBean.succ("修改成功");
    }

    @Override
    public RestFulBean<String> delete(Users users) {
        usersMapper.deleteById(users.getId());//根据id删除某条数据
        return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<Users> getById(Users users) {
        Users user =usersMapper.getById(users.getId());
        if(user.getImage()!=null){
            //本地获取图片路劲
         user.setImageUrl("http://localhost:8087/file/"+user.getImage());
        }
        return RestFulBean.succ(user);
    }
    @Override
    public RestFulBean<Map> upload(MultipartFile coverFile) {
        String destPath ="D:\\design\\images\\";
        // 存图片
        try{
            FileUtil.saveFile(coverFile, destPath,coverFile.getOriginalFilename());
        }
        catch(Exception e){
            return RestFulBean.error("请求异常");
        }
        Map map =new HashMap();
        //将图片名字返回 用于录入用户的时候 把这个值保存到image字段中
        map.put("imageName",coverFile.getOriginalFilename());
        //本地获取图片的路劲
   map.put("url","http://localhost:8087/file/"+coverFile.getOriginalFilename());

        return RestFulBean.succ(map);
    }

    @Override
    public RestFulBean<List<Users>> getTeachList() {
        List<Users> teachList=usersMapper.getTeachList();
        return RestFulBean.succ(teachList);
    }

    @Override
    public RestFulBean<List<Users>> getAdminList() {
        List<Users> adminList=usersMapper.getAdminList();
        return RestFulBean.succ(adminList);
    }
}
