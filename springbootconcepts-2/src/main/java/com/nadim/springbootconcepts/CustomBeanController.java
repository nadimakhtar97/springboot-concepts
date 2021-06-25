package com.nadim.springbootconcepts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nadim.springbootconcepts.CustomBean;

// Any class which is annotated by @Component is picked up by spring
// to create bean. Here in this case @RestController depends on other
// depended annotations which further depend on @Component annotation
// therefore @RestController is picked up by spring to create bean.

@RestController
public class CustomBeanController {

    // Here Autowired is used to inject customBean object as a dependency.
    @Autowired
    CustomBean customBean;

    @GetMapping("/customBean")
    public void printCustomBean()
    {
        System.out.println(customBean.getMessage());
        System.out.println(customBean.getData());
    }

}
