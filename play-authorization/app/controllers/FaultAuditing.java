package controllers;

import models.fault.Fault;

import java.util.List;

/**
 * Desc  :
 * -----
 * Author: <a href="mailto:ember319@gmail.com">ember</a>
 * Date  : 12-3-14
 * Time  : 下午11:55
 */
public class FaultAuditing extends Application{

    public static void index(){
        show(1);
    }

    public static void show(Integer page){
        Integer pageSequence = page == null || page < 0 ? 1 : page;
        int from = (pageSequence - 1) * pageSize;

        List<Fault> faults = Fault.find("select o from Fault o order by id desc")
                .from(from).fetch(pageSize);
        Long entityCount = Fault.count();

        render(entityCount, faults, pageSequence);
    }
}
