package com.smart_house;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bird {
    private final Texture img;
    Vector2 position;
    private float vy;
    private final float gravity;

    public Bird() {
        img = new Texture("bird1.png");
        position = new Vector2(100, 300);
        vy = 0;
        gravity = -0.7f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(img, position.x, position.y);
    }

    public void update() {

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            vy = 4;
        }
        vy += gravity;
        position.y += vy;
    }

    public void recreate() {
        position = new Vector2(100, 300);
        vy = 0;
    }
}
