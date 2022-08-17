#include "amendpersonwindow.h"
#include "ui_amendpersonwindow.h"

AmendPersonWindow::AmendPersonWindow(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::AmendPersonWindow)
{
    ui->setupUi(this);
}

AmendPersonWindow::~AmendPersonWindow()
{
    delete ui;
}
