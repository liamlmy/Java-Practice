// Given a random generator random5(),
// the return value of random5() is 0 - 4 with equal probability. Use random5() to implement random1000()

public class Solution {
  public int random1000() {
    while (true) {
      int random = 0;
      for (int i = 0; i < 5; i++) {
        random += RandomFive.random5() + 5 * random;
      }
      if (random < 3000) {
        return random % 1000;
      }
    }
  }
}
