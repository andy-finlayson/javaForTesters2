package com.javafortesters2.chap016random.examples;

import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by andfin on 13/01/2017.
 */
public class RandomTest {
    @Test
    public void randomNumber() {
        double rnd = Math.random();
        System.out.println(String.format("Generated %f random number", rnd));
        assertThat(rnd < 1.0d,is(true));
        assertThat(rnd > 0.0d,is(true));
        Random generate = new Random();
        int randomInt = generate.nextInt(10);
        System.out.println("nextInt = "+randomInt);
        double randomGaussian = generate.nextGaussian();
        System.out.println("nextGaussian = "+randomGaussian);

    }
    @Test
    public void create1000RandomsBetween15And20(){
        Set<Integer> randoms = new HashSet<>();
        Random generate = new Random();
        int minInt = 15;
        int maxInt = 20;

        for (int i = 0;i < 1000;i++){
            randoms.add(15+(generate.nextInt(6)));
        }
        assertThat(randoms.size(),is(6));
        assertThat(randoms.contains(15),is(true));
        assertThat(randoms.contains(16),is(true));
        assertThat(randoms.contains(17),is(true));
        assertThat(randoms.contains(18),is(true));
        assertThat(randoms.contains(19),is(true));
        assertThat(randoms.contains(20),is(true));
        System.out.println(randoms);
    }

    @Test
    public void gaussian(){
        int standardDeviationCount1 = 0;
        int standardDeviationCount2 = 0;
        int standardDeviationCount3 = 0;
        int standardDeviationCount4 = 0;
        int sampleSize = 1000;
        Random generate = new Random();
        for (int i = 0;i < sampleSize;i++){
            double randomGaussian = generate.nextGaussian();
            if(randomGaussian > -1.0d && randomGaussian < 1.0d)
                standardDeviationCount1++;
            if(randomGaussian > -2.0d && randomGaussian < 2.0d)
                standardDeviationCount2++;
            if(randomGaussian > -3.0d && randomGaussian < 3.0d)
                standardDeviationCount3++;
            if(randomGaussian > -4.0d && randomGaussian < 4.0d)
                standardDeviationCount4++;
        }

        float sd1 = (standardDeviationCount1/1000f)*100;
        float sd2 = (standardDeviationCount2/1000f)*100;
        float sd3 = (standardDeviationCount3/1000f)*100;
        float sd4 = (standardDeviationCount4/1000f)*100;
        System.out.println(sd1+" / "+sd2+" / "+sd3+" / "+sd4);
        assertTrue(sd1<sd2 && sd2<sd3 && sd3<sd4);
    }

}