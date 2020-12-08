package com.lushwe.tank.net;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2020-12-07 22:15
 * @since 0.1
 */
public class ServerFrame extends Frame {
    public static final ServerFrame INSTANCE = new ServerFrame();

    Button btnStart = new Button("start");
    TextArea taLeft = new TextArea();
    TextArea taRight = new TextArea();
    Server server = new Server();

    public ServerFrame() {
        this.setSize(1600, 600);
        this.setLocation(300, 30);
        this.add(btnStart, BorderLayout.NORTH);
        Panel p = new Panel(new GridLayout(1, 2));
        p.add(taLeft);
        p.add(taRight);
        this.add(p);

        taLeft.setFont(new Font("verderna", Font.PLAIN, 25));

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


    }

    public static void main(String[] args) {
        ServerFrame.INSTANCE.setVisible(true);
        ServerFrame.INSTANCE.server.serverStart();
    }

    public void updateServerMsg(String string) {
        this.taLeft.setText(taLeft.getText() + string + System.getProperty("line.separator"));
    }

    public void updateClientMsg(String string) {
        this.taRight.setText(taRight.getText() + string + System.getProperty("line.separator"));
    }
}
