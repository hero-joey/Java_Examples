package com.hero.hanlp;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.CustomDictionary;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

import java.util.List;

/**
 * Hello world!
 *
 */
public class Demo
{
    public static void main( String[] args )
    {
        // 动态增加
        CustomDictionary.add("I3000");
        CustomDictionary.add("I1000");
        CustomDictionary.add("免疫");
        CustomDictionary.add("凝血");
        CustomDictionary.add("血球");
        CustomDictionary.add("重启");

        List<Term> termList = NLPTokenizer.segment("中国科学院计算技术研究所的宗成庆教授正在教授自然语言处理课程");
        System.out.println(termList);

        termList = StandardTokenizer.segment("免疫产品I3000泵阀重启故障分析");
        //termList = NLPTokenizer.segment("免疫产品I3000泵阀重启故障分析");
        System.out.println(termList);

        termList = NLPTokenizer.segment("免疫产品I3000泵阀重启故障分析");
        //termList = NLPTokenizer.segment("免疫产品I3000泵阀重启故障分析");
        System.out.println(termList);

        List<String> keywordList = HanLP.extractKeyword("I3000重启", 5);
        System.out.println(keywordList);

    }
}
