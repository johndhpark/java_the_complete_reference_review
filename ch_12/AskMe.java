// An improved version of the "Decision Maker"
// program from Chapter 9. This version uses an
// enum, rather than interface variables, to
// represent the answers.

import java.util.Random;

// An enumeration of the possible answers.
enum Answers {
    YES, NO, MAYBE, LATER, SOON, NEVER
}

class Question {
    Random rand = new Random();

    Answers ask() {
        int prob = (int) (100 * rand.nextDouble());

        if (prob < 15) {
            return Answers.MAYBE; // 15%
        } else if (prob < 30) { // 15%
            return Answers.NO;
        } else if (prob < 60) {
            return Answers.YES; // 30%
        } else if (prob < 75) {
            return Answers.LATER; // 15%
        } else if (prob < 98) {
            return Answers.SOON; // 13%
        } else {
            return Answers.NEVER; // 2%
        }
    }
}

class AskMe {
    static void answer(Answers result) {
        switch (result) {
            case NO:
                System.out.println("No");
                break;
            case YES:
                System.out.println("Yes");
                break;
            case MAYBE:
                System.out.println("Maybe");
                break;
            case LATER:
                System.out.println("Later");
                break;
            case SOON:
                System.out.println("Soon.");
            case NEVER:
                System.out.println("Never.");
        }
    }

    public static void main(String[] args) {
        Question q = new Question();

        answer(q.ask());
        answer(q.ask());
        answer(q.ask());
        answer(q.ask());
    }
}