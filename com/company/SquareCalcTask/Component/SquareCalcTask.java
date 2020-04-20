package com.company.SquareCalcTask.Component;

import com.company.DataManagement.Component.OutputInterface;
import com.company.Lib.Component.TaskInterface;
import com.company.Lib.Dao.RepositoryInterface;
import com.company.SquareCalcTask.Model.FigureInterface;
import com.company.SquareCalcTask.Model.Rectangle;

public class SquareCalcTask implements TaskInterface {
    private RepositoryInterface<Rectangle> rectangleRepository;
    private OutputInterface output;

    public SquareCalcTask(RepositoryInterface<Rectangle> rectangleRepository, OutputInterface output) {
        this.rectangleRepository = rectangleRepository;
        this.output = output;
    }

    @Override
    public void run() {
        Rectangle rectangle = rectangleRepository.take();
        calcSquare(rectangle);
    }

    private void calcSquare(FigureInterface figure) {
        output.publishRow(String.format("Square is %d", figure.square()));
    }
}
