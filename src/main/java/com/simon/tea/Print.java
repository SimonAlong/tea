package com.simon.tea;

import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;

/**
 * @author zhouzhenyong
 * @since 2018/6/25 下午3:52
 */
@UtilityClass
public class Print {

    /**
     * 红色
     */
    public void showRed(String str) {
        System.out.print(ansi().fg(RED).render(str).reset());
    }

    public void showRedSpace(String str) {
        System.out.print(ansi().fg(RED).render(str).reset() + "   ");
    }

    public void showRedLn(String str) {
        System.out.println(ansi().fg(RED).render(str).reset());
    }

    /**
     * 黑色
     */
    public void showBlack(String str) {
        System.out.print(ansi().fg(BLACK).render(str).reset());
    }

    public void showBlackSpace(String str) {
        System.out.print(ansi().fg(BLACK).render(str).reset() + "   ");
    }

    public void showBlackLn(String str) {
        System.out.println(ansi().fg(BLACK).render(str).reset());
    }

    /**
     * 绿色
     */
    public void showGreen(String str) {
        System.out.print(ansi().fg(GREEN).render(str).reset());
    }

    public void showGreenSpace(String str) {
        System.out.print(ansi().fg(GREEN).render(str).reset() + "   ");
    }

    public void showGreenLn(String str) {
        System.out.println(ansi().fg(GREEN).render(str).reset());
    }

    /**
     * 黄色
     */
    public void showYellow(String str) {
        System.out.print(ansi().fg(YELLOW).render(str).reset());
    }

    public void showYellowSpace(String str) {
        System.out.print(ansi().fg(YELLOW).render(str).reset() + "   ");
    }

    public void showYellowLn(String str) {
        System.out.println(ansi().fg(YELLOW).render(str).reset());
    }

    /**
     * 蓝色
     */
    public void showBlue(String str) {
        System.out.print(ansi().fg(BLUE).render(str).reset());
    }

    public void showBlueSpace(String str) {
        System.out.print(ansi().fg(BLUE).render(str).reset() + "   ");
    }

    public void showBlueLn(String str) {
        System.out.println(ansi().fg(BLUE).render(str).reset());
    }

    /**
     * 品红
     */
    public void showMagenta(String str) {
        System.out.print(ansi().fg(MAGENTA).render(str).reset());
    }

    public void showMagentaSpace(String str) {
        System.out.print(ansi().fg(MAGENTA).render(str).reset() + "   ");
    }

    public void showMagentaLn(String str) {
        System.out.println(ansi().fg(MAGENTA).render(str).reset());
    }

    /**
     * 青色
     */
    public void showCyan(String str) {
        System.out.print(ansi().fg(CYAN).render(str).reset());
    }

    public void showCyanSpace(String str) {
        System.out.print(ansi().fg(CYAN).render(str).reset() + "   ");
    }

    public void showCyanLn(String str) {
        System.out.println(ansi().fg(CYAN).render(str).reset());
    }

    /**
     * 白色
     */
    public void showWhite(String str) {
        System.out.print(ansi().fg(WHITE).render(str).reset());
    }

    public void showWhiteSpace(String str) {
        System.out.print(ansi().fg(WHITE).render(str).reset() + "   ");
    }

    public void showWhiteLn(String str) {
        System.out.println(ansi().fg(WHITE).render(str).reset());
    }

    /**
     * 系统默认颜色
     */
    public void show(String str) {
        System.out.print(ansi().fg(DEFAULT).render(str).reset());
    }

    public void showSpace(String str) {
        System.out.print(ansi().fg(DEFAULT).render(str).reset() + "   ");
    }

    public void showLn(String str) {
        System.out.println(ansi().fg(DEFAULT).render(str).reset());
    }

    public void showCmdError(String input) {
        showError("命令不识别：" + input);
    }

    public void showError(String input) {
        showRedLn("error - " + input);
    }

    public void showTable(List<Map<String, Object>> bodies, String... heads) {
        showTableHead(heads);
        showTableBody(bodies);
        showTableCnt();
    }

    private void showTableHead(String... heads) {
        List<String> headList = Arrays.asList(heads);
        headList.add("index");
        showLn("------------------------------------------------------------------------");
        headList.forEach(h -> {
            show(h);
            show("          ");
        });
        showLn("");
        showLn("------------------------------------------------------------------------");
    }

    private void showTableBody(List<Map<String, Object>> bodies) {

    }

    private void showTableCnt() {

    }

    /**
     * 计算一行的最长长度
     */
    public Integer generateWidth(List<Map<String, Object>> bodies, String... heads) {
        Integer maxLength = 0;
    }

    public List<Integer> computeColumnMaxLength(List<Map<String, Object>> bodies, List<String> headList) {
        List<Integer> columnMaxLengthList = new ArrayList<>(headList.size()).stream().map(h -> 0)
            .collect(Collectors.toList());
        for (int i = 0; i < headList.size(); i++) {
            AtomicInteger max = new AtomicInteger(0);
            int finalI = i;
            bodies.stream().map(body->body.get(headList.get(finalI))).collect(Collectors.toList()).forEach(column->{
                max.set(Math.max(max.get(), String.valueOf(column).length()));
            });
        }
    }
}
