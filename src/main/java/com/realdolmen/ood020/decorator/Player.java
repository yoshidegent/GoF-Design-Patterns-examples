package com.realdolmen.ood020.decorator;

public interface Player {
    void hit();
    void fish();
    void sell();
    void fly();
    void addExperience(int exp);
    int getLevel();
}
