package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.GameObject;
import com.mygdx.game.PlantVsZombies;
import com.mygdx.game.Plants.PeaShooter;
import com.mygdx.game.Plants.Plant;
import com.mygdx.game.Zombies.NormalZombie;
import com.mygdx.game.Zombies.Zombie;

import java.util.ArrayList;
import java.util.Iterator;

public class GameObjectFactory {
    private static ArrayList<GameObject> GameObjects;
    private static ArrayList<GameObject> GameObjectsToAdd;
    private static PlantVsZombies Game;

    public static void initialize(PlantVsZombies game) {
        Game = game;
        GameObjects = new ArrayList<>();
        GameObjectsToAdd = new ArrayList<>();
    }

    public static void Render() {
        for (Iterator<GameObject> iterator = GameObjects.iterator(); iterator.hasNext(); ) {
            GameObject gameObject = iterator.next();
            Game.batch.draw(gameObject.GetCurrentFrame(), gameObject.X, gameObject.Y);
            gameObject.Render(Gdx.graphics.getDeltaTime());
            if (gameObject.CanRemove())
                iterator.remove();
        }
        GameObjects.addAll(GameObjectsToAdd);
        GameObjectsToAdd.clear();
    }

    public static void AddGameObject(GameObject p) {
        GameObjectsToAdd.add(p);
    }

    public static void AddPlant(int row) {
        PeaShooter p = new PeaShooter(5, 5);
        GameObjectsToAdd.add(p);
    }

    public static void AddZombie(int row) {
        NormalZombie Z = new NormalZombie(0, 0);
        GameObjectsToAdd.add(Z);
    }
}