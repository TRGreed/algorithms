package ru.greed.algorithms.lesson.second;

import org.springframework.util.CollectionUtils;
import ru.greed.algorithms.model.MinMaxDto;

import java.util.List;

public class SecondLessonService {

    public MinMaxDto findMinMaxCompact(List<Integer> inputList) {
        validateInput(inputList);

        MinMaxDto dto = init(inputList);

        for (int i = dto.getCurrentIndex(); i < inputList.size() - 1; i += 2) {
            int min = inputList.get(i);
            int max = inputList.get(i + 1);
            if (min > max) {
                int temp = min;
                min = max;
                max = temp;
            }
            if (min < dto.getMin()) {
                dto.setMin(min);
            }
            if (max > dto.getMax()) {
                dto.setMax(max);
            }
        }

        return dto;
    }

    private void validateInput(List<Integer> inputList) {
        if (CollectionUtils.isEmpty(inputList)) {
            throw new IllegalArgumentException("Список не должен быть пустым или null");
        }
    }

    private boolean isEven(int size) {
        return size % 2 != 0;
    }

    private MinMaxDto init(List<Integer> inputList) {
        MinMaxDto dto = new MinMaxDto();

        if (isEven(inputList.size())) {
            dto.setMin(inputList.get(0));
            dto.setMax(inputList.get(0));
            dto.setCurrentIndex(1);
        } else {
            if (inputList.get(0) < inputList.get(1)) {
                dto.setMin(inputList.get(0));
                dto.setMax(inputList.get(1));
            } else {
                dto.setMin(inputList.get(1));
                dto.setMax(inputList.get(0));
            }
            dto.setCurrentIndex(2);
        }
        return dto;
    }
}
