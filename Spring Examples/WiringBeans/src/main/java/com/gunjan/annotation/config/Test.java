package com.gunjan.annotation.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test
{
    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Game game = applicationContext.getBean("game", Game.class);
        game.setAwayTeam(new RedSox());
        game.setAwayTeam(new Cubs());
        game.playGame();
        System.out.println(game);
    }
}
