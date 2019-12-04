package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import javafx.geometry.Rectangle2D;
import org.graalvm.compiler.loop.MathUtil;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture bucketImage;
	private Texture dropImage;

	private OrthographicCamera camera;
	private Rectangle bucket;
	private Rectangle raindrop;

	private void spawnRaindrop() {
		raindrop = new Rectangle();
		raindrop.width = 64;
		raindrop.height = 64;

		raindrop.x = MathUtils.random(0, camera.viewportWidth - raindrop.width);
		raindrop.y = 420;
	}

	@Override
	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();
		bucketImage = new Texture("bucket.png");
		dropImage = new Texture("raindrop.png");

		bucket = new Rectangle();
		bucket.width = 64;
		bucket.height = 64;
		bucket.x = (camera.viewportWidth / 2) - (bucket.width / 2);
		bucket.y = 20;

		spawnRaindrop();
	}

	@Override
	public void render() {
		handleInput();
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//spawnRaindrop();

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		batch.draw(bucketImage, bucket.x, bucket.y);
		batch.draw(dropImage, raindrop.x, raindrop.y);
		batch.end();
	}

	private void handleInput() {
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			bucket.x -=20;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			bucket.x +=20;
		}
		if(bucket.x < 0){
			bucket.x = 0;
		}
		if(bucket.x > camera.viewportWidth - bucket.width){
			bucket.x = camera.viewportWidth - bucket.width;
		}
	}

	@Override
	public void dispose() {
		batch.dispose();
		bucketImage.dispose();
	}
}
