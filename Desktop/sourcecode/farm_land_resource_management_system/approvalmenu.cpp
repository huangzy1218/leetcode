#include "approvalmenu.h"
#include "ui_approvalmenu.h"

ApprovalMenu::ApprovalMenu(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::ApprovalMenu)
{
    ui->setupUi(this);
}

ApprovalMenu::~ApprovalMenu()
{
    delete ui;
}
