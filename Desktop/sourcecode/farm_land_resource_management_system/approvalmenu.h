#ifndef APPROVALMENU_H
#define APPROVALMENU_H

#include <QWidget>

namespace Ui {
class ApprovalMenu;
}

class ApprovalMenu : public QWidget
{
    Q_OBJECT

public:
    explicit ApprovalMenu(QWidget *parent = nullptr);
    ~ApprovalMenu();

private:
    Ui::ApprovalMenu *ui;
};

#endif // APPROVALMENU_H
