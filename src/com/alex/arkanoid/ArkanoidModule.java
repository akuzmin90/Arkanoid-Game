package com.alex.arkanoid;

import com.alex.arkanoid.service.BallManager;
import com.alex.arkanoid.service.BoardManager;
import com.alex.arkanoid.service.BrickManager;
import com.alex.arkanoid.service.EncounterManager;
import com.alex.arkanoid.service.impl.BallManagerImpl;
import com.alex.arkanoid.service.impl.BoardManagerImpl;
import com.alex.arkanoid.service.impl.BrickManagerImpl;
import com.alex.arkanoid.service.impl.EncounterManagerImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class ArkanoidModule extends AbstractModule {
	
	protected void configure() {
		bind(BrickManager.class).to(BrickManagerImpl.class).in(Singleton.class);
		bind(BoardManager.class).to(BoardManagerImpl.class).in(Singleton.class);
		bind(BallManager.class).to(BallManagerImpl.class).in(Singleton.class);
		bind(EncounterManager.class).to(EncounterManagerImpl.class).in(Singleton.class);
	}

}
