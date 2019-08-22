package com.neverend.blog;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SensitivewordEngine {

    /**
     * ֻ������С���д�
     */
    public static int minMatchTYpe = 1;

    /**
     * �����������д�
     */
    public static int maxMatchType = 2;

    /**
     * ���дʿ����д�����
     *
     * @return
     */
    public static int getWordSize() {
        if (SensitiveWordInit.sensitiveWordMap == null) {
            return 0;
        }
        return SensitiveWordInit.sensitiveWordMap.size();
    }

    /**
     * �Ƿ�������д�
     *
     * @param txt
     * @param matchType
     * @return
     */
    public static boolean isContaintSensitiveWord(String txt, int matchType) {
        boolean flag = false;
        for (int i = 0; i < txt.length(); i++) {
            int matchFlag = checkSensitiveWord(txt, i, matchType);
            if (matchFlag > 0) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * ��ȡ���д�����
     *
     * @param txt
     * @param matchType
     * @return ���д�����
     */
    public static Set<String> getSensitiveWord(String txt, int matchType) {
        Set<String> sensitiveWordList = new HashSet<String>();

        for (int i = 0; i < txt.length(); i++) {
            int length = checkSensitiveWord(txt, i, matchType);
            if (length > 0) {
                // �����������дʱ��浽������
                sensitiveWordList.add(txt.substring(i, i + length));
                i = i + length - 1;
            }
        }

        return sensitiveWordList;
    }

    /**
     * �滻���д�
     *
     * @param txt
     * @param matchType
     * @param replaceChar
     * @return
     */
    public static String replaceSensitiveWord(String txt, int matchType, String replaceChar) {
        String resultTxt = txt;
        Set<String> set = getSensitiveWord(txt, matchType);
        Iterator<String> iterator = set.iterator();
        String word = null;
        String replaceString = null;
        while (iterator.hasNext()) {
            word = iterator.next();
            replaceString = getReplaceChars(replaceChar, word.length());
            resultTxt = resultTxt.replaceAll(word, replaceString);
        }

        return resultTxt;
    }

    /**
     * �滻���д�����
     *
     * @param replaceChar
     * @param length
     * @return
     */
    private static String getReplaceChars(String replaceChar, int length) {
        String resultReplace = replaceChar;
        for (int i = 1; i < length; i++) {
            resultReplace += replaceChar;
        }

        return resultReplace;
    }

    /**
     * ������д�����
     *
     * @param txt
     * @param beginIndex
     * @param matchType
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static int checkSensitiveWord(String txt, int beginIndex, int matchType) {
        boolean flag = false;
        // ��¼���д�����
        int matchFlag = 0;
        char word = 0;
        Map nowMap = SensitiveWordInit.sensitiveWordMap;
        for (int i = beginIndex; i < txt.length(); i++) {
            word = txt.charAt(i);
            // �жϸ����Ƿ���������дʿ���
            nowMap = (Map) nowMap.get(word);
            if (nowMap != null) {
                matchFlag++;
                // �ж��Ƿ������дʵĽ�β�֣�����ǽ�β�����ж��Ƿ�������
                if ("1".equals(nowMap.get("isEnd"))) {
                    flag = true;
                    // �жϹ������ͣ������С����������ѭ�����������ѭ��
                    if (SensitivewordEngine.minMatchTYpe == matchType) {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        if (!flag) {
            matchFlag = 0;
        }
        return matchFlag;
    }


}
