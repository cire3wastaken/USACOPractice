package me.cire3.drafts;

import me.cire3.Kattio;
import me.cire3.MutablePair;
import me.cire3.Pair;

import java.io.IOException;

public class SpeedingTicket {
    public static void begin() throws IOException {
        Kattio io = new Kattio("problems/speedingticket/speedingticket");

        // segment to speed
        MutablePair<Integer, Integer>[] segmentsToSpeedLimit = new MutablePair[io.nextInt()];
        MutablePair<Integer, Integer>[] segmentsToBessieSpeed = new MutablePair[io.nextInt()];

        for (int i = 0; i < segmentsToSpeedLimit.length; i++)
            segmentsToSpeedLimit[i] = new MutablePair<>(io.nextInt(), io.nextInt());

        for (int i = 0; i < segmentsToBessieSpeed.length; i++)
            segmentsToBessieSpeed[i] = new MutablePair<>(io.nextInt(), io.nextInt());

        int worstInfraction = 0;

        MutablePair<Integer, Integer> activeBessie, activeSpeed;

        int bessieIndex = 0;
        int speedIndex = 0;

        while (true) {
            if (bessieIndex == segmentsToBessieSpeed.length && speedIndex == segmentsToSpeedLimit.length)
                break;

            if (bessieIndex > segmentsToBessieSpeed.length || speedIndex > segmentsToSpeedLimit.length)
                throw new RuntimeException("wtf happened");

            activeSpeed = segmentsToSpeedLimit[speedIndex];
            activeBessie = segmentsToBessieSpeed[bessieIndex];

            MutablePair<Integer, Integer> firstToExpire = Math.min(activeBessie.getFirst(), activeSpeed.getFirst()) == activeSpeed.getFirst() ? activeSpeed : activeBessie;

            if (firstToExpire.equals(activeBessie)) {
                segmentsToBessieSpeed[bessieIndex] = activeBessie.setFirst(activeBessie.getFirst() - firstToExpire.getFirst());
                bessieIndex++;
            }
            else {
                segmentsToSpeedLimit[speedIndex] = activeSpeed.setFirst(activeSpeed.getFirst() - firstToExpire.getFirst());
                speedIndex++;
            }

            worstInfraction = Math.max(worstInfraction, activeBessie.getSecond() - activeSpeed.getSecond());
        }

        System.out.println(worstInfraction);

        io.println(worstInfraction);
        io.close();
    }
}
