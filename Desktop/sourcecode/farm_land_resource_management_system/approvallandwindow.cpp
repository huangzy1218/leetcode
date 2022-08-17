#include "approvallandwindow.h"
#include "ui_approvallandwindow.h"

ApprovalLandWindow::ApprovalLandWindow(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::ApprovalLandWindow)
{
    ui->setupUi(this);
}

ApprovalLandWindow::~ApprovalLandWindow()
{
    delete ui;
}
