package com.sergeev.editor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextEditor {


    public static void main(String[] args) {
        String test = "При сочетании вопросительного и восклицательного знаков вначале ставится основной знак, " +
                "указывающий на цель высказывания – вопросительный знак, а затем – восклицательный знак как " +
                "показатель эмоциональной окрашенности высказывания: – Что же стоите-то?! – закричал он еще" +
                " издали (Шукш.); – Еще надо?! – Елизар стукнул кулаком по столу (Шукш.)." +
                "При сочетании вопросительного или восклицательного знака с многоточием знаки эти ставятся на месте " +
                "первой точки: – Ну, что они там?..  (Шукш.); – Сейчас зайдем к старику, так?.." +
                "  (Шукш.); «Эх, елки зеленые!.. » – горько подумал он (Шукш.).";
        System.out.println(editTextReplaceNewLine(test,3, "LOL"));
    }

    public static String editTextByIndex(String text, int index, char symbol) {
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("[a-zA-Z0-9А-Яа-я]{" + index + ",}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String replacement = replaceCharInWord(matcher.group(), index, symbol);
            matcher.appendReplacement(sb, replacement);
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    private static String replaceCharInWord(String word, int index, char c) {
        StringBuilder sb = new StringBuilder();
        sb.append(word.substring(0, index - 1)).append(c).append(word.substring(index, word.length()));
        return sb.toString();
    }

    //2.В тексте после буквы Р, если она не последняя в слове, ошибочно напечатана буква А вместо О.
    // Внести исправления в текст.
    public static String editTextWithWrongWordsLetterA(String text) {
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("ра|Ра");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String replacement = replaceCharInWord(matcher.group(), matcher.end(), 'о');
            matcher.appendReplacement(sb, replacement);
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
    public static String editTextReplaceNewLine(String text,int quantity, String toReplace) {
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("\\b[a-zA-Z0-9А-Яа-я]{" + quantity + "}\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            matcher.appendReplacement(sb, toReplace);
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

}
