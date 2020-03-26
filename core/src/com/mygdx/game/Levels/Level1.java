package com.mygdx.game.Levels;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Cards.puffshroom;
import com.mygdx.game.GameMap;
import com.mygdx.game.GameObjectFactory;
import com.mygdx.game.ImageFactory;
import com.mygdx.game.PlantVsZombies;
import com.mygdx.game.Zombies.NormalZombie;

public class Level1 extends World {
    public Level1(PlantVsZombies game) {
        super(game);
        this.background = new Texture("background1.jpg");
        this.Map = new GameMap(5);
        LoadObjects();
    }

    private void LoadObjects() {
        GameObjectFactory.AddZombie(new NormalZombie(0, 0), 1);
        ImageFactory.AddCard(new puffshroom());
    }
}
