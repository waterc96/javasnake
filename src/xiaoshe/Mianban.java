
package xiaoshe;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author daixuan
 * 2018年8月27日
 */
public class Mianban extends JFrame{
	public static void main(String[] args) {
		myhuabu.running();
}
}
class myhuabu extends JPanel implements KeyListener{
	public static  int S=1;
	public static int Speed=200;
	static ArrayList<Snake> list=new ArrayList<>();
	static Integer socre=0;
	//添加一个随机的food
	
	int sx=(((int)(Math.random()*20))*30+60);
	int sy=(((int)(Math.random()*12))*30+30);
		public void food() {
			int fx=(((int)(Math.random()*26))*30);
			int fy=(((int)(Math.random()*18))*30);
			list.add(new Snake(fx,fy));
			File snakefile=new File("G:\\javaee\\ttsnake\\socre.txt");
			if(!snakefile.exists()){
				try {
					snakefile.createNewFile();	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
try {
	FileOutputStream out=new FileOutputStream(snakefile);
	
	out.write(socre.toString().getBytes());
	FileInputStream in=new FileInputStream(snakefile);
	byte byt[]=new byte[1024];
	int len=in.read(byt);
			System.out.println(new String(byt,0,len));
			out.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			socre+=100;
		}
		//设置一个随机的蛇头
		public void setShe() {
			list.add(new Snake(sx,sy));
			
			
		}
		//蛇的移动
		public void move() {
			int t1;
			int t2 ;
			list.get(list.size()-2).x+=30*(list.size()-1);
			t1=list.get(list.size()-2).x;
			t2=list.get(list.size()-2).y;
			for(int i=list.size()-2;i>0;i--) {
			list.get(i).x=list.get(i-1).x;
			list.get(i).y=list.get(i-1).y;
			}
			list.get(0).x=t1;
			list.get(0).y=t2;
			if(myhuabu.list.get(0).x>800||myhuabu.list.get(0).y>500||
					myhuabu.list.get(0).y<0||myhuabu.list.get(0).x<0) {
				JOptionPane.showMessageDialog(null,"Game  Over! 你得了"+socre.toString()+"分哦");
				System.exit(0);
			}
		
			this.repaint();
			myhuabu.sleep(Speed);
		}
		//按下右键，蛇向右移动
		public void rightMove() {
			int t1;
			int t2 ;
			list.get(list.size()-2).x=list.get(0).x+30;
			list.get(list.size()-2).y=list.get(0).y;
			t1=list.get(list.size()-2).x;
			t2=list.get(list.size()-2).y;
			for(int i=list.size()-2;i>0;i--) {
			list.get(i).x=list.get(i-1).x;
			list.get(i).y=list.get(i-1).y;
			}
			list.get(0).x=t1;
			list.get(0).y=t2;
			if(myhuabu.list.get(0).x>780||myhuabu.list.get(0).y>480||myhuabu.list.get(0).y<0||myhuabu.list.get(0).x<0) {
				JOptionPane.showMessageDialog(null,"Game  Over! 你得了"+socre.toString()+"分哦");
				System.exit(0);
			}
		
			this.repaint();
			myhuabu.sleep(Speed);	
		}
		//按下左键，蛇向左移动
		public  void leftMove() {
			int t1;
			int t2 ;
			list.get(list.size()-2).x=list.get(0).x-30;
			list.get(list.size()-2).y=list.get(0).y;
			t1=list.get(list.size()-2).x;
			t2=list.get(list.size()-2).y;
			for(int i=list.size()-2;i>0;i--) {
			list.get(i).x=list.get(i-1).x;
			list.get(i).y=list.get(i-1).y;
			}
			list.get(0).x=t1;
			list.get(0).y=t2;
			if(myhuabu.list.get(0).x>780||myhuabu.list.get(0).y>480||myhuabu.list.get(0).y<0||myhuabu.list.get(0).x<0) {
				JOptionPane.showMessageDialog(null,"Game  Over! 你得了"+socre.toString()+"分哦");
				System.exit(0);
			}
			this.repaint();
			myhuabu.sleep(Speed);			
		}
		//按下上键，蛇向上移动
		public  void upMove() {
			int t1;
			int t2 ;
			list.get(list.size()-2).x=list.get(0).x;
			list.get(list.size()-2).y=list.get(0).y-30;
			t1=list.get(list.size()-2).x;
			t2=list.get(list.size()-2).y;
			for(int i=list.size()-2;i>0;i--) {
			list.get(i).x=list.get(i-1).x;
			list.get(i).y=list.get(i-1).y;
			}
			list.get(0).x=t1;
			list.get(0).y=t2;
			if(myhuabu.list.get(0).x>780||myhuabu.list.get(0).y>480||myhuabu.list.get(0).y<0||myhuabu.list.get(0).x<0) {
				JOptionPane.showMessageDialog(null,"Game  Over! 你得了"+socre.toString()+"分哦");
				System.exit(0);
			}

			this.repaint();
			myhuabu.sleep(Speed);		
		}
		//按下下键，蛇向下移动
		public  void downMove() {
			int t1;
			int t2 ;
			list.get(list.size()-2).x=list.get(0).x;
			list.get(list.size()-2).y=list.get(0).y+30;
			t1=list.get(list.size()-2).x;
			t2=list.get(list.size()-2).y;
			for(int i=list.size()-2;i>0;i--) {
			list.get(i).x=list.get(i-1).x;
			list.get(i).y=list.get(i-1).y;
			}
			list.get(0).x=t1;
			list.get(0).y=t2;
			if(myhuabu.list.get(0).x>780||myhuabu.list.get(0).y>480||myhuabu.list.get(0).y<0||myhuabu.list.get(0).x<0) {
				JOptionPane.showMessageDialog(null,"Game  Over! 你得了"+socre.toString()+"分哦");
				System.exit(0);
			}
		
			this.repaint();
			myhuabu.sleep(Speed);				
		}
public static void sleep(long time) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

public static void running() {	

			JFrame jframe =new JFrame();
			myhuabu dr= new myhuabu();
			jframe.setSize(1000,540);
			jframe.setVisible(true);
			jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jframe.add(dr);
			jframe.addKeyListener(dr);
//			DrowingBoard	 dr=new DrowingBoard(true);
//			jframe.setSize(JFRAME_X, JFRAME_Y);
//			jframe.setLocationRelativeTo(null);
//			jframe.add(dr);
//			jframe.addKeyListener(dr);
//			jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			dr.setPreferredSize(new Dimension(DrowingBoard.BOARD_X, DrowingBoard.BOARD_Y));
			//jframe.setContentPane(dr);
			dr.setShe();
			dr.food();
		while(true) {		
			if(S==5) {
			while(true) {
			if(S!=5) {
			break;
			}
			if(myhuabu.list.get(0).x==myhuabu.list.get(myhuabu.list.size()-1).x
			&&myhuabu.list.get(0).y==myhuabu.list.get(myhuabu.list.size()-1).y) {
			dr.food();
			}
			dr.rightMove();
			}
			}
			else if(S==2) {
			while(true) {
			if(S!=2) {
				break;
				}
			if(myhuabu.list.get(0).x==myhuabu.list.get(myhuabu.list.size()-1).x
			&&myhuabu.list.get(0).y==myhuabu.list.get(myhuabu.list.size()-1).y) {
					dr.food();
				}				
				dr.leftMove();
				}
				}
				else if(S==3) {
				while(true) {
				if(S!=3) {
					break;
				}
			if(myhuabu.list.get(0).x==myhuabu.list.get(myhuabu.list.size()-1).x
				&&myhuabu.list.get(0).y==myhuabu.list.get(myhuabu.list.size()-1).y) {
						dr.food();
					}
					if(myhuabu.list.get(0).x>780||myhuabu.list.get(0).y>480
							||myhuabu.list.get(0).y<0||myhuabu.list.get(0).x<0) {
						JOptionPane.showMessageDialog(null,"Game  Over! 你得了"+socre);
						System.exit(0);
					}
				dr.upMove();
				}
				}
				else if(S==4) {
				while(true) {
					if(S!=4) {
						break;
					}
					if(myhuabu.list.get(0).x==myhuabu.list.get(myhuabu.list.size()-1).x
							&&myhuabu.list.get(0).y==myhuabu.list.get(myhuabu.list.size()-1).y) {
						dr.food();					
					}
				dr.downMove();
				}
		}else {		
				while(true) {
					if(myhuabu.S!=1) {
						break;
					}
					if(myhuabu.list.get(0).x==myhuabu.list.get(myhuabu.list.size()-1).x&&myhuabu.list.get(0).y==myhuabu.list.get(myhuabu.list.size()-1).y) {
						dr.food();					
					}
				dr.move();
				}
				}
			}
		}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.addRenderingHints(hints);
		for(int line_x=0;line_x<=800;line_x=line_x+30) {
			g.drawLine(line_x, 0, line_x,480 );
			}
		for(int line_y=0;line_y<=500;line_y+=30) {
				g.drawLine(0, line_y, 780,line_y);
				}
		for(Snake s:list) {
			g2d.fillOval(s.x,s.y, 30, 30);	
			}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			S=3;
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			S=4;
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			S=5;
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			S=2;
		}
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}