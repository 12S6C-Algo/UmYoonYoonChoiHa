# UmYoonYoonChoiHa: 알고리즘 스터디 정리

🚀 **코딩 테스트 전에 반드시 확인해야 할 팁 모음**
효율적인 알고리즘 풀이와 중요 포인트를 한눈에 정리.
더 자세한 설명과 코드 예제는 [Wiki](https://github.com/12S6C-Algo/UmYoonYoonChoiHa/wiki) 에서 확인.

---

## 📌 주요 알고리즘 팁

### [BFS에서 `visited` 처리 방식 ](https://github.com/12S6C-Algo/UmYoonYoonChoiHa/wiki/BFS에서-visited-처리-방식)
- **Queue에 넣을 때 `visited` 처리**  
  → 빠름: 중복 탐색 방지.
- **Queue에서 꺼낼 때 `visited` 처리**  
  → 느림: 중복 탐색 발생 가능.

### 다익스트라 알고리즘
- **Queue에서 꺼내면서 `visited` 처리**  
  → 효율적: 불필요한 계산 최소화.

### 투 포인터
- **정렬된 배열**에서 부분 합, 구간 문제 해결에 효과적.  
  → 두 포인터를 양쪽에서 움직이며 탐색.

### 이진 탐색 (Binary Search)
- **중간 값을 기준**으로 범위를 좁히며 탐색.  
  → 배열/목록은 반드시 **정렬된 상태**여야 함.

### DP (동적 프로그래밍)
- **문제 분할 → 중복 계산 제거**  
  → `Memoization`이나 `Tabulation`으로 시간 복잡도 최적화.

---
## 🤝 참고 자료
- 📘 **Wiki**: [더 많은 팁과 코드 예제](https://github.com/12S6C-Algo/UmYoonYoonChoiHa/wiki)
- 💬 **문의**: [이슈 탭](https://github.com/12S6C-Algo/UmYoonYoonChoiHa/issues) 활용
