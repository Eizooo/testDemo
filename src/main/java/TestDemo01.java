
import org.springframework.beans.BeanUtils;

import java.util.*;

public class TestDemo01 {

    public static void main(String[] args) {
        Test04 test04 = new TestDemo01().new Test04();
        Test03 test03 = new Test03();
        Test1 test1 = new Test1();
        test1.setTest1("111");
        test1.setTime(new Date());

        Test2 test2 = new Test2();

        BeanUtils.copyProperties(test1,test2);

        System.out.println(test2);

    }
    class Test04{
        private String name;
        private Date birthday;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getBirthday() {
            return birthday;
        }

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }
    }

    public static class Test1{
        Date time;
        String test1;
        String test2;

        public Date getTime() {
            return time;
        }

        public void setTime(Date time) {
            this.time = time;
        }

        public String getTest1() {
            return test1;
        }

        public void setTest1(String test1) {
            this.test1 = test1;
        }

        public String getTest2() {
            return test2;
        }

        public void setTest2(String test2) {
            this.test2 = test2;
        }

        @Override
        public String toString() {
            return "Test1{" +
                    "time=" + time +
                    ", test1='" + test1 + '\'' +
                    ", test2='" + test2 + '\'' +
                    '}';
        }
    }

    public static class Test2{
        Date time;
        String test1;
        String test2;

        public Date getTime() {
            return time;
        }

        public void setTime(Date time) {
            this.time = time;
        }

        public String getTest1() {
            return test1;
        }

        public void setTest1(String test1) {
            this.test1 = test1;
        }

        public String getTest2() {
            return test2;
        }

        public void setTest2(String test2) {
            this.test2 = test2;
        }

        @Override
        public String toString() {
            return "Test2{" +
                    "time=" + time +
                    ", test1='" + test1 + '\'' +
                    ", test2='" + test2 + '\'' +
                    '}';
        }
    }
}
