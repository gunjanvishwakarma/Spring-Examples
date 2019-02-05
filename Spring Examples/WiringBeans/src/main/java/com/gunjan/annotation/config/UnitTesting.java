package com.gunjan.annotation.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class UnitTesting
{
    @Autowired
    Game game;
    
    @Autowired
    ApplicationContext applicationContext;
    
    @Test
    public void testPlayGame(){
        game.playGame();
    }
    
    @Test
    public void testGetAndSetHomeTeam(){
        Game game = applicationContext.getBean("game",Game.class);
        System.out.println(game.getHomeTeam());
    }
}
