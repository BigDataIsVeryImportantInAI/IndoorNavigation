# Indoor Navigation using beacon

----
## 개발 배경/목표

>* 건축물이 크고 복잡해짐에 따라 원하는 장소를 한번에 찾아가기가 쉽지 않음 

>* 사용자의 시간 효율성을 높이기 위해 실내 네비게이션 개발 필요

>* Beacon의 RSSI값과 스마트폰의 가속도 센서를 활용하여 사용자의 위치 파악

----
## 개발 구성 및 과정

>* 메인 화면에서 맵과 자신의 위치, 방향 표시 가능

>* 센서를 이용해 한걸음 한걸음마다 자신의 위치를 나타내는 아이콘이 애니메이션으로 이동

>* 센서에서 사용자의 위치 파악에서 나오는 오차범위를 비콘을 이용해 초기화

>* 길 찾기시 다이스트라 알고리즘으로 해당 지역까지 빨간 선으로 표시

>* 해당 지역 비콘 신호 취득시 길 안내 종료

----
## 개발 내용

>* 어플을 시작할 경우 블루투스 권한을 설정한다.

>* BTLE Scan을 반복하여 Beacon의 ScanRecode값을 받아 Major와 Minor 값 파싱한다.

>![스캔 코드](/image/code1.bmp)

>![데이터 구조](/image/image1.png)

>* 외부의 입력을 읽어내는 센서는 하드웨어 장치여서 디바이스마다 제공하는 센서 목록이 다르다. 하지만 여기서 사용하는 가속계와 자기장 센서는 스마트폰 기능에 필수적인 센서라 대부분의 스마트폰에는 탑제가 되어있다. 센서값을 수시로 읽고 작동하기 위해 센서 리스너를 구현한다.

>* 센서 리스너 메소드의 파라미터로 넘어온 SensorEvent 객체를 통해 type의 상수가 Sensor 클래스의 가속계, 자기장 센서의 상수와 맞는지 확인 후 이 값들로 걸음 검출과 보폭을 추정한다. x축을 담당하는 센서로 자신의 방향을, z축을 담당하는 센서로 걸음을 검출한다.

>* 걸음을 검출하기 위해 쓰이는 가속도 센서는 완벽한 것이 아니며 오차값과 중력값이 포함되어 있다. 이 값들을 보정하여 좀 더 정확한 걸음을 검출하기 위해 고주파 필터링과 저주파 필터링을 적용한다. 필터링 공식은 논문에 나와있다.

>* 사람의 걸음은 가속도 센서와 같이 걸었을 경우 z축으로 흔들리게 되는데 이 부분은 가속도센서 값이 증가와 감소를 반복하게 되는 부분이다. 여기서 영교차점을 검출하여 이용하여 가속도 값이 0이 되는 곳을 찾아서 그 사이의 시간동안을 한 번의 걸음 수로 인식한다. 빨간 중가로 하나를 Step 하나로 볼 수 있다.

>![필터링전후그래프](/image/image2.png)

>* Weinberg approach를 적용하여 보폭을 추정하였다.

>* 다익스트라 알고리즘은 그래프의 출발점과 도착점 사이의 최단 경로 문제를 푸는 알고리즘이다. 그래프의 모든 간선의 가중치는 음이 아닌 경우에 가중 방향 그래프 G = (V,E)에서 단일 출발점 최단 경로 문제를 푼다.

----
## 개발 관련 사항

>* 개발 언어 : Java

>* 개발 환경 : Eclipse ADT

>* 담당분야 : Beacon Scan과정, Beacon 리스트 설계, 각 값마다 해당하는 위치 할당, RSSI값으로 리스트 정렬, 센서 모듈 활성화와 Value 전달

>* 비콘의 경우 Reco 비콘을 사용 Major 값과 Minor 값의 수정에 있어선 제작 회사마다 다름

----
## 실행 화면

>![실행화면](/image/res1.png)
>![실행화면](/image/res2.png)
>![실행화면](/image/res3.png)
>![실행화면](/image/res4.png)
>![실행화면](/image/res5.png)

----
## 구조
>![전체구조](/image/system1.png)
>![전체구조](/image/system2.png)