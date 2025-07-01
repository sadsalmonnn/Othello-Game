package ca.utoronto.utm.assignment1.othello;

import java.util.Random;

/**
 * The OthelloRandomProbability class simulates probabilities of two computers,
 * P1 and P2, playing Othello with random strategies. It calculates the
 * probability of each player winning, distributes the data and applies the
 * bootstrap resampling method to estimate the likelihood of each player
 * winning. This includes the p1 and p2 distributed dataset, and the p1 and p2
 * bootstrap dataset.
 */
public class OthelloRandomProbability extends OthelloControllerRandomVSRandom {
  private float[] p1distributeddataset;
  private float[] p2distributeddataset;

  private float[] p1bootstrapdataset;
  private float[] p2bootstrapdataset;

  /**
   * Constructs a new OthelloRandomProbability
   */
  public OthelloRandomProbability() {
    super();
  }

  /**
   * Generate an array of probabilities of P1 and P2 winning, by simulating
   * numGames number of Othello games between two computers, each with a random
   * strategy.
   * 
   * @param numGames the number of games to simulate
   * @return an array of two floats, the first element is the probability of P1
   *         winning, and the second element is the probability of P2 winning.
   */
  public float[] generateProbability(int numGames) {
    int p1wins = 0, p2wins = 0;

    for (int i = 0; i < numGames; i++) {
      OthelloControllerRandomVSRandom oc = new OthelloControllerRandomVSRandom();
      oc.play();
      if (oc.othello.getWinner() == OthelloBoard.P1) {
        p1wins++;
      } else if (oc.othello.getWinner() == OthelloBoard.P2) {
        p2wins++;
      }
    }

    float[] probability = { (float) p1wins / numGames, (float) p2wins / numGames };

    return probability;
  }

  /**
   * Simulate a distribution of probabilities of P1 and P2 winning by generating
   * numSamples number of arrays, each of which contains the probability of P1 and
   * P2 winning by simulating numGames number of games.
   * 
   * @param numGames   the number of games to simulate
   * @param numSamples the number of samples to generate
   */
  public void simulateDistribution(int numGames, int numSamples) {
    float[] distributionp1 = new float[numSamples];
    float[] distributionp2 = new float[numSamples];

    for (int i = 0; i < numSamples; i++) {
      float[] probability = generateProbability(numGames);
      distributionp1[i] = probability[0];
      distributionp2[i] = probability[1];
    }

    this.p1distributeddataset = distributionp1;
    this.p2distributeddataset = distributionp2;
  }

  /**
   * Overloaded method to simulate a distribution of probabilities of P1 and P2
   * winning by simulating 1000 games 20 times.
   */
  public void simulateDistribution() {
    int numGames = 1000;
    int numSamples = 20;

    simulateDistribution(numGames, numSamples);
  }

  /**
   * Resample the dataset by randomly selecting elements from the current
   * distributed dataset of p1 and p2 winning probabilities, and creating a new
   * dataset of P1 and P2 winning probabilities.
   * 
   * @param numSamples the number of samples in the new dataset
   */
  public void bootstrapResampleDataset(int numSamples) {
    float[] p1resampledata = new float[numSamples];
    float[] p2resampledata = new float[numSamples];

    Random rand = new Random();
    for (int i = 0; i < numSamples; i++) {
      int randomindex = rand.nextInt(p1distributeddataset.length);
      p1resampledata[i] = this.p1distributeddataset[randomindex];
      p2resampledata[i] = this.p2distributeddataset[randomindex];
    }

    this.p1bootstrapdataset = p1resampledata;
    this.p2bootstrapdataset = p2resampledata;
  }

  /**
   * Prints the simulation of a Bootstrap distribution of probabilities of P1 and
   * P2 winning by simulating numGames number of games, and then resample the
   * dataset with a size of numSamples.
   * 
   * @param numGames   the number of games to simulate
   * @param numSamples the number of samples in the new dataset
   */
  public void simulateBootstrap(int numgames, int numSamples) {
    simulateDistribution(numgames, numSamples);

    System.out.println("p1's distribution: " + toString(this.p1distributeddataset));
    System.out.println("p2's distribution: " + toString(this.p2distributeddataset));

    bootstrapResampleDataset(numSamples);

    System.out.println("p1's resampled distribution: " + toString(this.p1bootstrapdataset));
    System.out.println("p2's resampled distribution: " + toString(this.p2bootstrapdataset));

    System.out.println("The average of p1's resampled distribution: " + average(p1bootstrapdataset));
    System.out.println("The average of p1's resampled distribution: " + average(p2bootstrapdataset));
  }

  /**
   * Overloaded method to prints the simulation of a Bootstrap distribution of
   * probabilities of P1 and P2 winning by simulating 10000 games, and then
   * resample the dataset with a size of 20.
   */
  public void simulateBootstrap() {
    int numgames = 10000;
    int numSamples = 20;
    simulateBootstrap(numgames, numSamples);
  }

  /**
   * Calculate the average of a given dataset.
   * 
   * @param dataset the dataset to calculate the average of
   * @return the average of the dataset
   */
  public float average(float[] dataset) {
    float sum = 0;
    for (float data : dataset) {
      sum += data;
    }
    return sum / dataset.length;
  }

  /**
   * 
   * @param dataset the dataset to convert to a string
   * @return a string representation of the dataset as a list of floats.
   */
  public String toString(float[] dataset) {
    String listdata = "[";
    for (float data : dataset) {
      listdata += data + ", ";
    }
    return listdata.substring(0, listdata.length() - 2) + "]";
  }

  /**
   * Run this to test the OthelloRandomProbability class. The class simulates a
   * bootstrap distribution of probabilities of P1 and P2 winning by simulating
   * 10000 games, and then resample the dataset with a size of 20.
   */
  public static void main(String[] args) {
    OthelloRandomProbability testprobability = new OthelloRandomProbability();

    testprobability.simulateBootstrap(10000, 20);
  }
}
