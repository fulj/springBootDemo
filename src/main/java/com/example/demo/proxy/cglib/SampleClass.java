package com.example.demo.proxy.cglib;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * 和JDK的Proxy不同的是，Enhancer既能够代理普通的class，也能够代理接口 Enhancer创建一个被代理对象的子类并且拦截所有的方法调用
 * （包括从Object中继承的toString和hashCode方法）。Enhancer不能够拦截final方法，例如Object.getClass()方法，这是由于
 * Java final方法语义决定的。基于同样的道理，Enhancer也不能对fianl类进行代理操作。这也是Hibernate为什么不能持久化final class的原因。
 *
 */
public class SampleClass {
    public  void test(){
        System.out.println("hello world");
    }
    public  String test(String s){
        return "hello world";
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before method run...");
                Object ret = methodProxy.invokeSuper(o, args);
                System.out.println("after method run");
                return ret;
            }
        });
        SampleClass sample = (SampleClass) enhancer.create();
        sample.test();
    }


    /**
     * FixedValue用来对所有拦截的方法返回相同的值，从输出我们可以看出来，Enhancer对非final方法test()、toString()、hashCode()进行了拦截，
     * 没有对getClass进行拦截。由于hashCode()方法需要返回一个Number，但是我们返回的是一个String，这解释了上面的程序中为什么会抛出异常。
     */
    @Test
    public void testFixedValue() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "Hello cglib";
            }
        });
        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println(proxy.test(null)); //拦截test，输出Hello cglib
        System.out.println(proxy.toString());
        System.out.println(proxy.getClass());
        System.out.println(proxy.hashCode());
    }
    @Test
    public void testInvocationHandler() throws Exception{
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getDeclaringClass() != Object.class && method.getReturnType() == String.class){
                    return "hello cglib";
                }else{
                    throw new RuntimeException("Do not know what to do");
                }
            }
        });
        SampleClass proxy = (SampleClass) enhancer.create();
        Assert.assertEquals("hello cglib", proxy.test(null));
        Assert.assertNotEquals("Hello cglib", proxy.toString());
    }
}
