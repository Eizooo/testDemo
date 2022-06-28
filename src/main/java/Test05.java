import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test05 {
    static int j;
    public static void main(String[] args) {
        //返回Arrays内部类,没有remove
        //List<String> list = Arrays.asList("1","2","3","4","5");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1025; i++) {
            list.add(i + "");
        }

        int start = 0;
        int end = 100;
        while ( end < list.size() ){
            List<String> subList = list.subList(start, end);
            System.out.println(subList);
            start = end;
            end = end + 10;
            if(end > list.size()){
                List<String> subList1 = list.subList(start, list.size());
                System.out.println(subList1);
            }
            System.out.println(start+"-------------->"+end);
        }

    }

    public static void changeList(List<String> list){

        System.out.println("list.size() = " + list.size());
        try {
            Thread.sleep(50);
            j = ++j;
            System.out.println("第"+ j +"次调用");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
