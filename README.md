### 🐻 DS 코딩 프로젝트(Toy)
-----
### 💻 구현 기능
| Index | 구현 기능 | 구현 여부 |
| --- | --- | --- |
| 1 | 회원 관리(CRUD) | ✅ |
| 2 | 채팅 구현| ✅ | 

----
## 채팅기능 정리
### STOMP
- 간단한 메세지 전송 위한 프로토콜 : 메세지 브로커를  publisher - subscriber 방식 사용
- 메시지 브로커는 발행자가 보낸 메시지를 구독자에게 전달해주는 역할을 한다.
- STOMP는 HTTP와 비슷하게 frame 기반 프로토콜 command, header, body로 이루어져 있다.
- 웹소켓과 stomp 함께 사용하면 frame 구조 정의 되있어 통신에 유용
- **STOMP 통신과정**

  <img width="761" alt="image" src="https://github.com/bangyewon/Meeting/assets/90364660/05c84021-efc9-44f6-a165-6b8e4905773f">
- 수신자는 /topic 경로를 구독하고 있고 발행자는 /app 혹은 /topic으로 메시지를 보내는 모습을 확인 가능
- 만약 발행자가 /topic 경로로 메시지를 보내면 바로 수신자에게 도착하고 /app 경로로 메시지를 보내면 가공을 한 다음 보내게 됨
  
  ----
  ### 메세지 브로커
<img width="761" alt="image" src="https://github.com/bangyewon/Meeting/assets/90364660/60f01ae9-05d6-42f9-9135-27f8c4e3db7c">

- 구독자는 특정 Topic 구독하고 해당 Topic으로 메세지 날림
- 메세지 브로커가 메세지 관리해서 구독중인 사람들에게 메세지 보냄
- 메세지 보낼때 메세지 브로커를 통해 브로커가 구독자들에게 전달하는 방식





