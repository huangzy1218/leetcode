#include "approvalwindow.h"
#include "ui_approvalwindow.h"

ApprovalWindow::ApprovalWindow(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::ApprovalWindow)
{
    ui->setupUi(this);
}

ApprovalWindow::~ApprovalWindow()
{
    delete ui;
}
