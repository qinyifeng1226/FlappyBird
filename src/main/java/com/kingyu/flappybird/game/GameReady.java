package com.kingyu.flappybird.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import com.kingyu.flappybird.util.Constant;
import com.kingyu.flappybird.util.GameUtil;

/**
 * 游戏启动界面类
 * 
 * @author Kingyu
 *
 */
public class GameReady {

	private final BufferedImage titleImg;
	private final BufferedImage noticeImg;

	private int flash = 0; // 图像闪烁参数

	// 构造器中进行初始化，装载图像资源
	public GameReady() {
		titleImg = GameUtil.loadBufferedImage(Constant.TITLE_IMG_PATH);
		noticeImg = GameUtil.loadBufferedImage(Constant.NOTICE_IMG_PATH);
	}

	public void draw(Graphics g) {
		// 计算title图像的x、y坐标
		int x = Constant.FRAME_WIDTH - titleImg.getWidth() >> 1; //x坐标为窗口中央
		int y = Constant.FRAME_HEIGHT / 3;  //y坐标为游戏窗口的1/3处
		g.drawImage(titleImg, x, y, null); // 绘制

		// 使notice的图像闪烁
		final int COUNT = 30; // 闪烁周期
		if (flash++ > COUNT)
			GameUtil.drawImage(noticeImg, Constant.FRAME_WIDTH - noticeImg.getWidth() >> 1, Constant.FRAME_HEIGHT / 5 * 3, g);
		if (flash == COUNT * 2) // 重置闪烁参数
				flash = 0;
	}

}
