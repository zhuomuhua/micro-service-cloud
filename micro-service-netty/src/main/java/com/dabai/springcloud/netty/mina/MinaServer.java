package com.dabai.springcloud.netty.mina;

import lombok.extern.slf4j.Slf4j;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.FilterEvent;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.springframework.util.ObjectUtils;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * @author zhuhaolin
 * @version v2.0
 * @Description: TODO
 * @Date 2020/3/11
 */
@Slf4j
public class MinaServer {
    private static final Integer PORT = 9999;
    private static final String EXIT = "exit";

    public static void main(String[] args) throws Exception {
        IoAcceptor acceptor = new NioSocketAcceptor();
        acceptor.getSessionConfig().setReadBufferSize(2048);
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
        DefaultIoFilterChainBuilder filterChain = acceptor.getFilterChain();
        filterChain.addLast("codec", new ProtocolCodecFilter(
                new TextLineCodecFactory(
                        Charset.forName("UTF-8"),
                        LineDelimiter.WINDOWS.getValue(),
                        LineDelimiter.WINDOWS.getValue())));

        //设置处理器
        acceptor.setHandler(new IoHandlerAdapter() {
            @Override
            public void sessionCreated(IoSession session) throws Exception {
                log.info("server session created");
                super.sessionCreated(session);
            }

            @Override
            public void sessionOpened(IoSession session) throws Exception {
                log.info("server session opened");
                super.sessionOpened(session);
            }

            @Override
            public void sessionClosed(IoSession session) throws Exception {
                log.info("server session closed");
                super.sessionClosed(session);
            }

            @Override
            public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
                log.info("server session idle");
                super.sessionIdle(session, status);
            }

            @Override
            public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
                log.warn("server session exception", cause);
                super.exceptionCaught(session, cause);
            }

            @Override
            public void messageReceived(IoSession session, Object message) throws Exception {
                if (!ObjectUtils.isEmpty(message)) {
                    String content = message.toString();
                    log.info("客户端信息：id：{}, content：{}", session.getId(), content);

                    if (content.equalsIgnoreCase(EXIT)) {
                        session.closeNow();
                        return;
                    }
                }
            }

            @Override
            public void messageSent(IoSession session, Object message) throws Exception {

            }

            @Override
            public void inputClosed(IoSession session) throws Exception {
                log.info("server input closed");
                super.inputClosed(session);
            }

            @Override
            public void event(IoSession session, FilterEvent event) throws Exception {
                log.info("server event");
                super.event(session, event);
            }
        });
        acceptor.bind(new InetSocketAddress(PORT));
    }
}
