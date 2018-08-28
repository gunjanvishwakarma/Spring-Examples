package com.gunjan;
import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Main {

  public static void main(String[] args) throws Exception {
    BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("context.xml"));
    MtBean testBean = (MtBean) beanFactory
        .getBean("afterBean");
    testBean.showValues();
  }
}

class MtBean {
  private String firstName;

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void showValues() {
    System.out.println("First name: " + this.firstName);
  }
}
class NullArgumentsNotAllowedBeforeAdvice implements MethodBeforeAdvice {
  public void before(Method method, Object[] arguments, Object target)
      throws Throwable {
	  System.out.println("OMG");
    if (arguments == null || arguments.length == 0) {
      return;
    }
    
    for (int i = 0; i < arguments.length; i++) {
      Object argument = arguments[i];
      if (argument == null) {
        throw new IllegalArgumentException(
          "Value for argument [" + i + "] is required but not present " +
          "for method [" + method + "]!"
        );
      }
    }
  }
}