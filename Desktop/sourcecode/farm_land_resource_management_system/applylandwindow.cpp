#include "applylandwindow.h"
#include "ui_applylandwindow.h"

ApplyLandWindow::ApplyLandWindow(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::ApplyLandWindow)
{
    ui->setupUi(this);
}

ApplyLandWindow::~ApplyLandWindow()
{
    delete ui;
}
