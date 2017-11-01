// Given a random generator random5(),
// the return value of random5() is 0 - 4 with equal probability. Use random5() to implement random7().

public class Solution {
  public int random7() {
    while (true) {
      int random = RandomFive.random5() * 1 + RandomFive.random5();
      if (random < 8) {
        return random % 7;
      }
    }
  }
}
