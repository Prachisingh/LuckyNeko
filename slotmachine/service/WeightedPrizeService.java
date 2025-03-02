package slotmachine.service;


import slotmachine.dto.WeightedPrizeData;

import java.util.Random;

/**
 * Class that retrieves prizes based on chances given in maths.
 */
public class WeightedPrizeService {

    public static int getPrizes(Random rng, WeightedPrizeData weightedPrizeData) {

        int randomNumber = rng.nextInt(weightedPrizeData.getWeightsSum());
        for (var config : weightedPrizeData.getConfigs()) {
            if (config.getWeight() > 0 && randomNumber >= config.getStartingRange() && randomNumber < config.getEndRange()) {
                return config.getPrize();
            }
        }

        throw new RuntimeException("shouldn't reach here, please fix your get prize config code");
    }

    public static int[] getMultiplePrizes(Random rng, WeightedPrizeData weightedPrizeData) {
        int randomNumber = rng.nextInt(weightedPrizeData.getWeightsSum());
        for (var config : weightedPrizeData.getMultiplePrizeConfigs()) {
            if (config.getWeight() > 0 && randomNumber >= config.getStartingRange() && randomNumber < config.getEndRange()) {
                return config.getPrize();
            }
        }

        throw new RuntimeException("shouldn't reach here, please fix your get prize config code");
    }

}