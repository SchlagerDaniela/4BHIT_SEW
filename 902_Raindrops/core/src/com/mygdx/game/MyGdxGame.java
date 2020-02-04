package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import javafx.geometry.Rectangle2D;
import org.graalvm.compiler.loop.MathUtil;

import java.util.Iterator;

public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture bucketImage;
    private Texture dropImage;

    private OrthographicCamera camera;
    private Rectangle bucket;
    private Array<Rectangle> raindrops;
    private long lastDropTime;
    private Sound dropSound;
    private Music rainMusic;

    private void spawnRaindrop() {
        Rectangle raindrop = new Rectangle();
        raindrop.width = 64;
        raindrop.height = 64;

        raindrop.x = MathUtils.random(0, camera.viewportWidth - raindrop.width);
        raindrop.y = 420;

        raindrops.add(raindrop);
        lastDropTime = TimeUtils.nanoTime();
    }

    @Override
    public void create() {
        raindrops = new Array<>();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();
        bucketImage = new Texture("bucket.png");
        dropImage = new Texture("raindrop.png");

        dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
        rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));

        rainMusic.setLooping(true);
        rainMusic.play();

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

        //neuen Regentropfen jede Sekunden erstellen
        if (TimeUtils.nanoTime() - lastDropTime > 1000000000)
            spawnRaindrop();

        //Regentropfen animieren
        moveRaindrops();

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(bucketImage, bucket.x, bucket.y);
        for (Rectangle raindrop : raindrops) {
            batch.draw(dropImage, raindrop.x, raindrop.y);
        }
        batch.end();
    }

    private void moveRaindrops() {
        Iterator<Rectangle> it = raindrops.iterator();
        while (it.hasNext()) {
            Rectangle raindrop = it.next();
            raindrop.y -= 200 * Gdx.graphics.getDeltaTime();

            //Regentropfen verlässt Spielfeld?
            if (raindrop.y + raindrop.height < 0) {
                it.remove();
            }

            //Regentropfen aufgefangen?
            if (raindrop.overlaps(bucket)) {
                dropSound.play();
            	it.remove();
            }

        }
    }

    private void handleInput() {
    	//Keyboard Input
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            bucket.x -= 450 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            bucket.x += 450 * Gdx.graphics.getDeltaTime();
        }

        //Maus bzw. Touch Steuerung
		if(Gdx.input.isTouched()){
			Vector3 touchPosition = new Vector3();
			touchPosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPosition);
			bucket.x = (int) (touchPosition.x - bucket.width/2);
		}

        if (bucket.x < 0) {
            bucket.x = 0;
        }
        if (bucket.x > camera.viewportWidth - bucket.width) {
            bucket.x = camera.viewportWidth - bucket.width;
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        bucketImage.dispose();
        dropImage.dispose();
        rainMusic.dispose();
        dropSound.dispose();
    }
}
