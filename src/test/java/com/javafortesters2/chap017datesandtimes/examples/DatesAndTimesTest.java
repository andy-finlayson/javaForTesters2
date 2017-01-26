package com.javafortesters2.chap017datesandtimes.examples;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by andfin on 16/01/2017.
 */
public class DatesAndTimesTest {
    @Test
    public void currentTime(){
        long startTime = System.currentTimeMillis();
        for( int i=0;i<10000;i++){
            System.out.println("Current Time = "+System.currentTimeMillis());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("End Time = "+endTime);
        System.out.println("Time Taken = "+(endTime-startTime));
    }
    @Test
    public void nanoTime(){
        long startTime = System.nanoTime();
        for( int i=0;i<10;i++){
            System.out.println("Current Time = "+System.nanoTime());
        }
        long endTime = System.nanoTime();
        System.out.println("End Time = "+endTime);
        System.out.println("Time Taken = "+(endTime-startTime));
    }
    @Test
    public void date() {
        Date date = new Date();
        System.out.println(date.toString());
        long inOneWeeksTime = new Date().getTime();
        inOneWeeksTime = inOneWeeksTime+(1000*60*60*24*7);
        Date oneWeekFromNow = new Date(inOneWeeksTime);
        System.out.println(oneWeekFromNow.toString());
        assertThat(date.before(oneWeekFromNow),is(true));
    }
    @Test
    public void calendar(){
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime().getTime());
        System.out.println(cal.toString());
        Calendar sameDate = Calendar.getInstance();
        sameDate.setTime(cal.getTime());

        cal.set(2013,Calendar.DECEMBER,23,23,49,54);
        assertThat(cal.get(Calendar.MONTH),is(Calendar.DECEMBER));
        assertThat(cal.get(Calendar.HOUR),is(Calendar.HOUR_OF_DAY));
        cal.add(Calendar.YEAR,-2);
        cal.add(Calendar.MONTH,-6);
        cal.add(Calendar.DATE,-20);
        assertThat(cal.get(Calendar.YEAR), is(2011));
        assertThat(cal.get(Calendar.MONTH), is(Calendar.JUNE));
        assertThat(cal.get(Calendar.DATE), is(3));


    }
    @Test
    public void calendarChangeTheYear(){
        Calendar cal = Calendar.getInstance();
        cal.set(2013,Calendar.DECEMBER,23,23,49,54);
        cal.add(Calendar.DAY_OF_MONTH, 17);
        assertThat(cal.get(Calendar.YEAR),is(2014));
        assertThat(cal.get(Calendar.MONTH),is(Calendar.JANUARY));
        assertThat(cal.get(Calendar.DATE),is(9));
        cal.add(Calendar.DAY_OF_MONTH,-17);
    }
    @Test
    public void moreCalendar() {
        Calendar cal = Calendar.getInstance();
        cal.set(2013, Calendar.DECEMBER, 15);
        assertThat(cal.get(Calendar.DAY_OF_YEAR),is(349));
        assertThat(cal.get(Calendar.DAY_OF_WEEK),is(1));
        assertThat(cal.get(Calendar.DAY_OF_WEEK),is(Calendar.SUNDAY));
    }


}
