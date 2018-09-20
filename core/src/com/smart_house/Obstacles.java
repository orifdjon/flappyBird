package com.smart_house;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Obstacles {
    class WallPair {
         Vector2 position;
        private float speed;
        private int offset;
         Rectangle emptySpace;


        public WallPair(Vector2 position) {
            this.position = position;
            this.speed = 2;
            this.offset = new Random().nextInt(200);
            this.emptySpace = new Rectangle(position.x, position.y - offset + 300, 50, betweenDistance);
        }

        public void update() {
            position.x -= speed;
            if (position.x < -50) {
                position.x = 800;
                offset = new Random().nextInt(250);
            }
            emptySpace.x = position.x;
        }
    }

    static WallPair[] obs;
    private Texture tx;
    private int betweenDistance;

    public Obstacles() {
        tx = new Texture("wall.png");
        obs = new WallPair[4];
        betweenDistance = 270;
        int startPosX = 400;
        for (int i = 0; i < obs.length; i++) {
            obs[i] = new WallPair(new Vector2(startPosX, 0));
            startPosX += 220;
        }
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < obs.length; i++) {
            batch.draw(tx, obs[i].position.x, obs[i].position.y);
            batch.draw(tx, obs[i].position.x, obs[i].position.y + betweenDistance + tx.getHeight() - obs[i].offset);
        }
    }

    public void update() {
        for(int i = 0; i < obs.length; i++) {
            obs[i].update();
        }
    }

    public void recreate() {
        int startPosX = 400;
        for (int i = 0; i < obs.length; i++) {
            obs[i] = new WallPair(new Vector2(startPosX, 0));
            startPosX += 220;
        }
    }
}
