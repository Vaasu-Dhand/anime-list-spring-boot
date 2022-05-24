package com.spring.AnimeList.utils;

import com.spring.AnimeList.model.AnimeTitle;

import java.util.Comparator;

public class Utils {
    public static class NameComparator implements Comparator<AnimeTitle> {
        @Override
        public int compare(AnimeTitle animeTitle1, AnimeTitle animeTitle2) {
            return animeTitle1.getName().compareTo(animeTitle2.getName());
        }
    }
}
