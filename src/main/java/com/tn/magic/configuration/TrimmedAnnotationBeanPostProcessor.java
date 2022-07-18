package com.tn.magic.configuration;

import com.tn.magic.annotation.Trimmed;
import lombok.SneakyThrows;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class TrimmedAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    @SneakyThrows
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        var beanType = bean.getClass();
        if (beanType.isAnnotationPresent(Trimmed.class)) {
            return createProxy(beanType);
        }
        return bean;
    }

    private Object createProxy(Class<?> beanType) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanType);
        MethodInterceptor methodInterceptor = (obj, method, args, methodProxy) -> {
            for (int i = 0; i < args.length; i++) {
                args[i] = trimIfStringObj(args[i]);
            }
            return trimIfStringObj(methodProxy.invokeSuper(obj, args));
        };
        enhancer.setCallback(methodInterceptor);
        return enhancer.create();
    }

    private Object trimIfStringObj(Object arg) {
        return arg instanceof String str
               ? str.trim()
               : arg;

    }
}
