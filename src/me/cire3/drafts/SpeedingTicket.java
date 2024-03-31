package me.cire3.drafts;

import me.cire3.Kattio;
import me.cire3.Pair;

import java.io.IOException;

public class SpeedingTicket {
    public static void begin() throws IOException {
        Kattio io = new Kattio("problems/speedingticket/speedingticket");

        // segment to speed
        Pair<Integer, Integer>[] segmentsToSpeedLimit = new Pair[io.nextInt()];
        Pair<Integer, Integer>[] segmentsToBessieSpeed = new Pair[io.nextInt()];

        for (int i = 0; i < segmentsToSpeedLimit.length; i++)
            segmentsToSpeedLimit[i] = new Pair<>(io.nextInt(), io.nextInt());

        for (int i = 0; i < segmentsToBessieSpeed.length; i++)
            segmentsToBessieSpeed[i] = new Pair<>(io.nextInt(), io.nextInt());

        int worstInfraction = 0;

        Pair<Integer, Integer> activeBessie, activeSpeed;

        int bessieIndex = 0;
        int speedIndex = 0;

        while (true) {
            if (bessieIndex == segmentsToBessieSpeed.length && speedIndex == segmentsToSpeedLimit.length)
                break;

            activeSpeed = segmentsToSpeedLimit[speedIndex];
            activeBessie = segmentsToBessieSpeed[bessieIndex];

            Pair<Integer, Integer> firstToExpire = Math.min(activeBessie.getFirst(), activeSpeed.getFirst()) == activeSpeed.getFirst() ? activeSpeed : activeBessie;

            if (firstToExpire.equals(activeBessie))
                bessieIndex++;
            else
                speedIndex++;

            worstInfraction = Math.max(worstInfraction, activeBessie.getSecond() - activeSpeed.getSecond());
        }
    }
}
