package 笔记例子;

import java.lang.annotation.Annotation;

//@MyAnnotation1(age = 45, sex = false, value = "25")没写把target写上类级别,所有不能使用类上
//@Deprecated
@MyAnnotation(age = 15, sex = false, value = "ll")
class Animal1{

}
public class TestAnnotation {
    public static void main(String[] args) {
        Class o=Animal1.class;
        Annotation[] k= o.getAnnotations();
        for (int i = 0; i < k.length; i++) {
            MyAnnotation ll=(MyAnnotation) k[i];
            System.out.println(ll.age()+ll.name()+ll.sex());
        }
    }
}

