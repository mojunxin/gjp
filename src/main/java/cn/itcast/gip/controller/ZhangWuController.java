package cn.itcast.gip.controller;

import cn.itcast.gip.domain.ZhangWu;
import cn.itcast.gip.service.ZhangWuService;

import java.util.List;

public class ZhangWuController {
    private ZhangWuService service = new ZhangWuService();
    /*
    删除
     */
    public  void deleteZhangWu(int zwid){
        service.deleteZhangWu(zwid);
    }

    /*
    定义方法 实现编辑账务的功能
     */
    public void editZhangWu(ZhangWu zw){
        service.editZhangWu(zw);
    }

    /*
    定义方法实现添加的功能
     */
    public void  addZhangWu(ZhangWu zw){
        service.addZhangWu(zw);
    }

    //定义用于查询所有的方法
    //方法由视图层调用 方法调用service层
    public List<ZhangWu> selectAll(){
        return service.selectAll();
    }
    //定义部分查询得方法
    public List<ZhangWu> select(String startData , String endData){
        return service.select(startData,endData);
    }
}
