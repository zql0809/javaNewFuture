package demo.designModel.structureMode.proxyStatic;

import com.google.common.base.CharMatcher;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;
import com.google.common.io.CharStreams;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyOwnSubject implements Subject {

    @Override
    public String proxyForSomeOne(String qParam) {
        //普通的hashsset会乱序  导致去重不能按照原有的顺序排列
        Set<String> sets = Sets.newLinkedHashSet();
        //字符串去重
        for(int i=0;i<qParam.length();i++){
            char a = qParam.charAt(i);
            sets.add(String.valueOf(a));
        }
        return String.join("", sets);
    }

}
