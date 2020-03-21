package demo.guavaTest;

import com.google.common.base.*;
import com.google.common.collect.*;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.common.io.Files;
import demo.Dog;

import java.util.*;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * 这是google提供的操作集合类的工具类
 */
public class GuavaUtils {
    //对于null 使用optional迫使你积极思考 引用缺失的情况  例如一个方法返回值可能是一个null 你可能忘记
    //将方法的返回类型指定为Optional，也可以迫使调用者思考返回的引用缺失的情形

    //20200311 --->Objects 方法 java.utils
    public void testObjects() {
        String aNull = null;
        //判定一个对象是否为空  若不抛出异常则可用
        boolean q = Objects.isNull(aNull);
        Objects.equals("d", "d");
        //可以用来判定对象是否为空  并且抛出空指针异常  这样就优化了 if(a == null){ throw new Exception("对象为空")}
        String message = Objects.requireNonNull(null, "你的字符串对象为空");
        //获取一个对象的哈希值
        Objects.hashCode("hashcode");

    }

    public void testGuava(){
        //判定字符串是否为空 或 ""
        Strings.isNullOrEmpty("test");

        //第一个是初始字符串 第二个参数是操作之后的长度  第三个是添加的字符  ---末尾操作
        String pad = Strings.padEnd("foo", 4, 'o');
        System.out.print(pad);
        //这个是在首部操作
        String start = Strings.padStart("study", 7, 's');
        System.out.print(start);

        //他们是一对可逆操作
        String e = Strings.nullToEmpty("");//这个方法可以避免String类型的null指针 -宽松
        String m = Strings.emptyToNull("");//这个方法遇到空字符串当作空指针处理 -较严格
        System.out.print(e+""+m);

        // 将字符串中的Tab和多个空格转为一个空格
        String tabsAndSpaces = "String with   spaces	and	tabs";
        tabsAndSpaces =CharMatcher.WHITESPACE.collapseFrom(tabsAndSpaces, ' ');
        System.out.println(tabsAndSpaces);
        //CharMatcher 简化String类型正则表达式  使String处理起来很方便  但是复杂的处理还是需要正则表达式
        CharMatcher.DIGIT.replaceFrom("a/bc", "ddd");
    }

    public Optional<String> getOption(){
        //使用Optional进行函数的返回设置  可以让使用者判定这个返回值会不会为空
        Optional optional = Optional.ofNullable(new GuavaUtils());
        optional.get();
        return  optional;
    }

    //定义了Subscribe的就是一个监听者(即为观察者)
    @Subscribe
    public  void subscrib(final String event){
        System.out.print("消息处理。。");
        System.out.print(event);
    }

    public void eventBus(){
        //定义消息总线  类似与rabbitMq之类的消息队列 只是消息队列可以建立不同的topic(类似一个EvenBus) 根据不同key tag group进行发送消息
        EventBus eventBus = new EventBus();
        //开始注册监听者
        System.out.print("消息事件发送开始...");
        eventBus.register(new GuavaUtils());
        eventBus.post("222");
        System.out.print("消息事件发送结束...");
    }


    //20200312

    //filter  transform
    public void testLikelyJdk8(){
        List<Dog> dogList = Lists.newArrayList(new Dog("sss",111),new Dog("ppp", 222));
        Iterable<Dog> iterables = FluentIterable.from(dogList).filter(new Predicate<Dog>() {
            @Override
            public boolean apply(Dog dog) {
                return dog.getAge()>112;//这里就把111过滤掉了
            }
        });

        Iterable<String> maps = FluentIterable.from(dogList).transform(new Function<Dog, String>() {
            @Override
            public String apply(Dog dog) {
                return Joiner.on(':').join(dog.getName(),dog.getAge());
            }
        });
        //Consumer消费java8 (T t)-{};有输入没有输出  类似循环处理方法不需要返回
        iterables.forEach(new Consumer<Dog>() {
            @Override
            public void accept(Dog s) {
                System.out.print(s.toString());
            }
        });
    }

    /**
     * 测试set集合的 合集 union 交集 intersection 差集 difference
     */
    public void testSet(){
        Set<String> aSet = Sets.newHashSet("3","2","1");
        Set<String> bSet = Sets.newHashSet("4","2","6");

        Set<String> q = Sets.intersection(aSet, bSet);
        q.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        System.out.println("\n");
        Set<String> qe = Sets.difference(aSet,bSet);//差集就是前面减去后面
        qe.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        System.out.println("\n");
        Set<String> qw = Sets.union(aSet, bSet);
        qw.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
    //这里就跳过了 矩阵
    public void testMaps(){
        //Lists Maps Sets
        List<String> list = Lists.newArrayList();//新建一个列表 可以入参

        Maps.newHashMap();
        Maps.transformValues(Maps.newHashMap(), new Function<Object, Object>() {
            @Override
            public Object apply(Object o) {
                return null;
            }
        });

        Map<String,String> q = Maps.uniqueIndex(Lists.newArrayList("2","20"), new Function<String, String>() {
            @Override
            public String apply(String v) {
                return v+"id";
            }
        });
        //转换entry值 返回值   方法名(key  value)
        Map<String,String> qq = Maps.transformEntries(q, new Maps.EntryTransformer<String, String, String>() {
            @Override
            public String transformEntry(String s, String s2) {
//                System.out.print("iner"+s+"     "+s2+";");
                return s2+"qqq";
            }
        });
        qq.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.print(s+"     "+s2+";");
            }
        });
    }

    //ArrayListMultimap 允许重复的键值对
    public void testArrayListMultiMap(){
        ArrayListMultimap<String,String> multimap = ArrayListMultimap.create();
        multimap.put("q", "1");
        multimap.put("w", "2");
        multimap.put("e", "3");
        multimap.put("q", "4");
        multimap.asMap().forEach((x,y)->{
            System.out.print(x+"  "+y);
        });//自动构建为 Map<String,List<...>>;
        //不可重复
        HashBiMap<String,String> biMap = HashBiMap.create();
    }

    /**
     * 测试文件类操作
     */
    public void testFile(){
        //
    }

}
