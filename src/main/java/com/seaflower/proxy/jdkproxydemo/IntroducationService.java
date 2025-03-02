package com.seaflower.proxy.jdkproxydemo;

import lombok.Data;

/*
 * 具体的实现类
 */
@Data
public class IntroducationService implements IntruducationInterface {

    public void sayHi() {
        System.out.println("Hi, zgw");
    }
}
